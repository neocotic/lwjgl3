/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.openvr;

import javax.annotation.*;

import java.nio.*;

import org.lwjgl.*;
import org.lwjgl.system.*;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.system.MemoryStack.*;

/**
 * <h3>Member documentation</h3>
 * 
 * <ul>
 * <li>{@code bScrollWheelVisible} &ndash; is this controller currently set to be in a scroll wheel mode</li>
 * </ul>
 * 
 * <h3>Layout</h3>
 * 
 * <pre><code>
 * struct RenderModel_ControllerMode_State_t {
 *     bool bScrollWheelVisible;
 * }</code></pre>
 */
@NativeType("struct RenderModel_ControllerMode_State_t")
public class RenderModelControllerModeState extends Struct implements NativeResource {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    public static final int
        BSCROLLWHEELVISIBLE;

    static {
        Layout layout = __struct(
            __member(1)
        );

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();

        BSCROLLWHEELVISIBLE = layout.offsetof(0);
    }

    RenderModelControllerModeState(long address, @Nullable ByteBuffer container) {
        super(address, container);
    }

    /**
     * Creates a {@link RenderModelControllerModeState} instance at the current position of the specified {@link ByteBuffer} container. Changes to the buffer's content will be
     * visible to the struct instance and vice versa.
     *
     * <p>The created instance holds a strong reference to the container object.</p>
     */
    public RenderModelControllerModeState(ByteBuffer container) {
        this(memAddress(container), __checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() { return SIZEOF; }

    /** Returns the value of the {@code bScrollWheelVisible} field. */
    @NativeType("bool")
    public boolean bScrollWheelVisible() { return nbScrollWheelVisible(address()); }

    /** Sets the specified value to the {@code bScrollWheelVisible} field. */
    public RenderModelControllerModeState bScrollWheelVisible(@NativeType("bool") boolean value) { nbScrollWheelVisible(address(), value); return this; }

    /**
     * Copies the specified struct data to this struct.
     *
     * @param src the source struct
     *
     * @return this struct
     */
    public RenderModelControllerModeState set(RenderModelControllerModeState src) {
        memCopy(src.address(), address(), SIZEOF);
        return this;
    }

    // -----------------------------------

    /** Returns a new {@link RenderModelControllerModeState} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed. */
    public static RenderModelControllerModeState malloc() {
        return create(nmemAllocChecked(SIZEOF));
    }

    /** Returns a new {@link RenderModelControllerModeState} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed. */
    public static RenderModelControllerModeState calloc() {
        return create(nmemCallocChecked(1, SIZEOF));
    }

    /** Returns a new {@link RenderModelControllerModeState} instance allocated with {@link BufferUtils}. */
    public static RenderModelControllerModeState create() {
        return new RenderModelControllerModeState(BufferUtils.createByteBuffer(SIZEOF));
    }

    /** Returns a new {@link RenderModelControllerModeState} instance for the specified memory address. */
    public static RenderModelControllerModeState create(long address) {
        return new RenderModelControllerModeState(address, null);
    }

    /** Like {@link #create(long) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    @Nullable
    public static RenderModelControllerModeState createSafe(long address) {
        return address == NULL ? null : create(address);
    }

    /**
     * Returns a new {@link RenderModelControllerModeState.Buffer} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed.
     *
     * @param capacity the buffer capacity
     */
    public static RenderModelControllerModeState.Buffer malloc(int capacity) {
        return create(__malloc(capacity, SIZEOF), capacity);
    }

    /**
     * Returns a new {@link RenderModelControllerModeState.Buffer} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed.
     *
     * @param capacity the buffer capacity
     */
    public static RenderModelControllerModeState.Buffer calloc(int capacity) {
        return create(nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    /**
     * Returns a new {@link RenderModelControllerModeState.Buffer} instance allocated with {@link BufferUtils}.
     *
     * @param capacity the buffer capacity
     */
    public static RenderModelControllerModeState.Buffer create(int capacity) {
        return new Buffer(__create(capacity, SIZEOF));
    }

    /**
     * Create a {@link RenderModelControllerModeState.Buffer} instance at the specified memory.
     *
     * @param address  the memory address
     * @param capacity the buffer capacity
     */
    public static RenderModelControllerModeState.Buffer create(long address, int capacity) {
        return new Buffer(address, capacity);
    }

    /** Like {@link #create(long, int) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    @Nullable
    public static RenderModelControllerModeState.Buffer createSafe(long address, int capacity) {
        return address == NULL ? null : create(address, capacity);
    }

    // -----------------------------------

    /** Returns a new {@link RenderModelControllerModeState} instance allocated on the thread-local {@link MemoryStack}. */
    public static RenderModelControllerModeState mallocStack() {
        return mallocStack(stackGet());
    }

    /** Returns a new {@link RenderModelControllerModeState} instance allocated on the thread-local {@link MemoryStack} and initializes all its bits to zero. */
    public static RenderModelControllerModeState callocStack() {
        return callocStack(stackGet());
    }

    /**
     * Returns a new {@link RenderModelControllerModeState} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack the stack from which to allocate
     */
    public static RenderModelControllerModeState mallocStack(MemoryStack stack) {
        return create(stack.nmalloc(ALIGNOF, SIZEOF));
    }

    /**
     * Returns a new {@link RenderModelControllerModeState} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack the stack from which to allocate
     */
    public static RenderModelControllerModeState callocStack(MemoryStack stack) {
        return create(stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    /**
     * Returns a new {@link RenderModelControllerModeState.Buffer} instance allocated on the thread-local {@link MemoryStack}.
     *
     * @param capacity the buffer capacity
     */
    public static RenderModelControllerModeState.Buffer mallocStack(int capacity) {
        return mallocStack(capacity, stackGet());
    }

    /**
     * Returns a new {@link RenderModelControllerModeState.Buffer} instance allocated on the thread-local {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param capacity the buffer capacity
     */
    public static RenderModelControllerModeState.Buffer callocStack(int capacity) {
        return callocStack(capacity, stackGet());
    }

    /**
     * Returns a new {@link RenderModelControllerModeState.Buffer} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack the stack from which to allocate
     * @param capacity the buffer capacity
     */
    public static RenderModelControllerModeState.Buffer mallocStack(int capacity, MemoryStack stack) {
        return create(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    /**
     * Returns a new {@link RenderModelControllerModeState.Buffer} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack the stack from which to allocate
     * @param capacity the buffer capacity
     */
    public static RenderModelControllerModeState.Buffer callocStack(int capacity, MemoryStack stack) {
        return create(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
    }

    // -----------------------------------

    /** Unsafe version of {@link #bScrollWheelVisible}. */
    public static boolean nbScrollWheelVisible(long struct) { return memGetByte(struct + RenderModelControllerModeState.BSCROLLWHEELVISIBLE) != 0; }

    /** Unsafe version of {@link #bScrollWheelVisible(boolean) bScrollWheelVisible}. */
    public static void nbScrollWheelVisible(long struct, boolean value) { memPutByte(struct + RenderModelControllerModeState.BSCROLLWHEELVISIBLE, value ? (byte)1 : (byte)0); }

    // -----------------------------------

    /** An array of {@link RenderModelControllerModeState} structs. */
    public static class Buffer extends StructBuffer<RenderModelControllerModeState, Buffer> implements NativeResource {

        /**
         * Creates a new {@link RenderModelControllerModeState.Buffer} instance backed by the specified container.
         *
         * Changes to the container's content will be visible to the struct buffer instance and vice versa. The two buffers' position, limit, and mark values
         * will be independent. The new buffer's position will be zero, its capacity and its limit will be the number of bytes remaining in this buffer divided
         * by {@link RenderModelControllerModeState#SIZEOF}, and its mark will be undefined.
         *
         * <p>The created buffer instance holds a strong reference to the container object.</p>
         */
        public Buffer(ByteBuffer container) {
            super(container, container.remaining() / SIZEOF);
        }

        public Buffer(long address, int cap) {
            super(address, null, -1, 0, cap, cap);
        }

        Buffer(long address, @Nullable ByteBuffer container, int mark, int pos, int lim, int cap) {
            super(address, container, mark, pos, lim, cap);
        }

        @Override
        protected Buffer self() {
            return this;
        }

        @Override
        protected Buffer newBufferInstance(long address, @Nullable ByteBuffer container, int mark, int pos, int lim, int cap) {
            return new Buffer(address, container, mark, pos, lim, cap);
        }

        @Override
        protected RenderModelControllerModeState newInstance(long address) {
            return new RenderModelControllerModeState(address, container);
        }

        @Override
        public int sizeof() {
            return SIZEOF;
        }

        /** Returns the value of the {@code bScrollWheelVisible} field. */
        @NativeType("bool")
        public boolean bScrollWheelVisible() { return RenderModelControllerModeState.nbScrollWheelVisible(address()); }

        /** Sets the specified value to the {@code bScrollWheelVisible} field. */
        public RenderModelControllerModeState.Buffer bScrollWheelVisible(@NativeType("bool") boolean value) { RenderModelControllerModeState.nbScrollWheelVisible(address(), value); return this; }

    }

}